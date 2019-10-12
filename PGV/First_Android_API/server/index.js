var express = require('express');
var bodyParser = require('body-parser');
var app = express();
var cors = require('cors');

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: true }))

// parse application/json
//app.use(bodyParser.json())

app.use(cors());

const port = 40000;

const primed_regen = 
    {
        name: 'primed regen',
        quantity: 0
    }

const catalog = [
    {
        name: 'primed flow',
        quantity: 0
    },
    {
        name: 'primed ravage',
        quantity: 0
    },
    {
        name: 'primed regen',
        quantity: 0
    }
]

const showPrimed_regen = (req, res) => {
    res.send(primed_regen);
}

const showCatalog = (req, res) => {
    res.send(catalog);
}   

const showMod = (req, res) => {
    if (isNaN(req.query)) {
        const result = catalog.filter(item => item.name == req.query.name);
        if (result.length == 0) {
            res.json('not found');
        } else {
            res.send(result[0]);
        }
    } else {
        res.json('Please don´t use numbers');
    }

}

app.get('/catalog', showCatalog);
app.get('/mod', showMod);
app.get('/primed_regen', showPrimed_regen);

app.listen(port, () => {
    console.log('Runing on http://localhost:' + port);
});