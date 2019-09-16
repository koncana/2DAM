var express = require('express');
var bodyParser = require('body-parser');
var app = express();
app.use(bodyParser.urlencoded({ exrtended: true }));

const port = 40000;


const catalog = [
    {
        name: 'primed flow',
        quantity: 0
    },
    {
        name: 'primed ravage',
        quantity: 0
    }
]

const showCatalog = (req, res) => {
    res.send(catalog);
}

const showItem = (req, res) => {
    if (isNaN(req.item.name)) {
        const res = catalog.filter(item => item.name == req.query.name);
        if (res.length == 0) {
            console.log("not found");
            res.json('not found');
        } else {
            res.send(res);
        }
    } else {
        console.log('Please don´t use numbers');
        res.json('Please don´t use numbers');
    }

}

app.get('/catalog', showCatalog);
app.get('/item', showItem);

app.listen(port, () => {
    console.log('Runing on http://localhost:' + port);
});