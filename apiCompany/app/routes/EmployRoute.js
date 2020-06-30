const express = require('express');

const EmployController = require('../controllers/EmployController');

const Router = express.Router();

Router.get('/', EmployController.index)             //apicompany.com/employ/ Index: Listar todos los productos
    .post('/', EmployController.find, EmployController.create)             //apicompany.com/employ/ Create: Crear un nuevo producto
    .get('/:key/:value', EmployController.find, EmployController.show)     //apicompany.com/employ/ Show: Muestra un producto en especifico
    .put('/:key/:value', EmployController.find, EmployController.update)   //apicompany.com/employ/ Update: Actualizar un producto en especifico
    .delete('/:key/:value', EmployController.find, EmployController.remove);//apicompany.com/employ/ Remove:  elimina un elemento

module.exports = Router;