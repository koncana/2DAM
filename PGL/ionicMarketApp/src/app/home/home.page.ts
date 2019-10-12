import { Component } from '@angular/core';
import { PrimeMarketService, SendMod } from '../services/prime-market.service';
import { ToastController, AlertController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  private namePost: string;
  private quantityPost: number;
  private mods: Array<Mods>;
  private verify: boolean;

  constructor(private api: PrimeMarketService, private toast: ToastController, private alertController: AlertController, private toastCtrl: ToastController) {
  }

  async ngOnInit() {
    this.connectApiAll();
    this.verify = true;
  }

  async connectApiAll() {
    await this.api.getAllRequest().subscribe((res: Mods) => {
      let i = 0;
      this.mods = new Array(res.length);
      while (res.length > i) {
        this.mods[i] = res[i];
        i++;
      }
      this.verify = true;
    });
  }

  async connectApi() {
    await this.api.getRequest(this.namePost).subscribe((res: Mods) => {
      let i = 0;
      this.mods = new Array(res.length);
      while (res.length > i) {
        this.mods[i] = res[i];
        i++;
      }
      this.verify = false;
    });
  }

  async addObject() {
    var hasNumber = /\d/;
    if (this.namePost !== undefined && this.namePost.length > 0 && typeof (this.namePost) === "string" && !hasNumber.test(this.namePost)) {
      if (this.quantityPost !== undefined && typeof (this.quantityPost) === "number" && this.quantityPost >= 0) {
        let mod: SendMod = {
          name: this.namePost,
          quantity: this.quantityPost
        }
        await this.api.postRequest(mod).subscribe(async () => {
          this.toastMessage("Mod successfully created");
          if (this.verify) {
            this.connectApiAll();
          } else {
            this.connectApi();
          }
        });
      } else {
        this.toastMessage("Write the quantity input properly, please");
      }
    } else {
      this.toastMessage("Write the name input properly, please");
    }

  }

  async toastMessage(mesg: string) {
    let toast = this.toastCtrl.create({
      message: mesg,
      duration: 3000,
      position: 'top'
    });
    (await toast).present();
  }

  async removeObject(toRemove: string) {
    await this.api.deleteRequest(toRemove).subscribe(async () => {
      this.toastMessage("Mod successfully removed");
      if (this.verify) {
        this.connectApiAll();
      } else {
        this.connectApi();
      }
    });
  }

  async modifyObject(name: string) {
    const alert = await this.alertController.create({
      header: 'Mod to modify',
      inputs: [
        {
          name: 'name',
          type: 'text',
          placeholder: 'New name'
        },
        {
          name: 'quantity',
          type: 'number',
          placeholder: 'New quantity'
        }
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          cssClass: 'secondary',
          handler: () => {
          }
        }, {
          text: 'Ok',
          handler: async (data) => {
            var hasNumber = /\d/;
            
            if (data.name !== undefined && data.name.length > 0 && typeof (data.name) === "string" && !hasNumber.test(data.name)) {
              if (data.quantity !== undefined && typeof (Number(data.quantity)) === "number" && data.quantity >= 0) {
                let mod: SendMod = {
                  name: data.name,
                  quantity: data.quantity
                }
                this.api.putRequest(name, mod).subscribe(() => {
                  if (this.verify) {
                    this.connectApiAll();
                  } else {
                    this.connectApi();
                  }
                  this.toastMessage("Mod successfully modified");
                });
              }
              else {
                this.toastMessage("Write the quantity input properly, please");
              }
            } else {
              this.toastMessage("Write the name input properly, please");
            }

          }
        }
      ]
    });
    await alert.present();
  }

  async increaseQuantity(name: string, quantity: number) {
    quantity++;
    let mod: SendMod = {
      name: name,
      quantity: quantity
    }
    this.api.putRequest(name, mod).subscribe(async () => {
      this.toastMessage("Mod successfully modified");
      if (this.verify) {
        this.connectApiAll();
      } else {
        this.connectApi();
      }
    });

  }

  async decreaseQuantity(name: string, quantity: number) {
    if (quantity > 0) {
      quantity--;
      let mod: SendMod = {
        name: name,
        quantity: quantity
      }
      this.api.putRequest(name, mod).subscribe(async () => {
        this.toastMessage("Mod successfully modified");
        if (this.verify) {
          this.connectApiAll();
        } else {
          this.connectApi();
        }
      });
    } else{
      this.toastMessage("Quantity can not be negative");
    }
  }
}

class Mods {
  name: string;
  quantity: number;
  length: number;
}

