           const mongoose = require('mongoose');

const EmploySchema = new mongoose.Schema({
    id: {
        type: Number,
        unique: true,
        required: true
    },
    nombre: {
        type: String,
        unique: true,
        required: true
    },
    edad: {
        type: Number,
        unique: true,
        required: true
    },
    salario: {
        type: Number,
        unique: true,
        required: true
    },
    birthday: {
        type: Date,
        default: Date.now()
    }
});

 const EmployModel = mongoose.model('employescollection', EmploySchema);
// console.log(`Encontrar Productos Mongo: ${EmployMongoose.find({nombre: 'Fernando'})}`);
 module.exports = EmployModel;