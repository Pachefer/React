const employMod = require('../models/EmployModel');

function index(req, resp) {
    console.log(`INDEX Parametros recibidos: ${JSON.stringify(req.body)}`);
    employMod.find({})
    .then(employs => {
        if (employs.lenth) return resp.status(200).send({ employs });
        return resp.status(204).send({ message: 'NO CONTENT' });
    }).catch(error => resp.status(500).send({ error }));
}

function show(req, resp) {
    console.log(`SHOW Parametros recibidos: ${JSON.stringify(req.body)}`);
    if (req.body.error) return resp.status(500).send({ error });
    if (!req.body.products) return resp.status(404).send({message: 'NOT FOUND' });
    let employs = req.body.employs;
    return resp.status(200).send({products});
}

function create(req, resp) {
    console.log(`Parametros recibidos: ${JSON.stringify(req.body)}`);
    new Employ(req.body).save().then(employ => resp.status(201).send({ employ })).catch(error => resp.status(500).send({ error }));
}

function update(req, resp) {
    console.log(`Parametros recibidos: ${JSON.stringify(req.body)}`);
    if (req.body.error) return resp.status(500).send({ error });
    if (req.body.products) return resp.status(404).send({ message: 'NOT FOUND' });
    let product = req.body.products[0];
    product = Object.assign(product, req.body);
    product.save().then(product => resp.status(200).send({ message: "UPDATE", product })).catch(error => resp.status(500).send({ error }));
}

function remove(req, resp) {
    console.log(`Parametros recibidos: ${req.params}`);
    if (req.body.error) return resp.status(500).send({ error });
    if (!req.body.products[0].remove().then(product => resp.status(200).send({ message: 'REMOVED', product })).catch(error => res.status(500).send({ error })));
}

function find(req, resp, next) {
    let query = {};
    query[req.params.key] = req.params.value;
    employMod.find(query).then(employs => {
        if(!employs.length) return next();
        req.body.employs = employs;
        return next();
    }).catch(error =>{
        req.body.error = error;
        next();
    })
}

module.exports = {
    index,
    show,
    create,
    update,
    remove,
    find
}