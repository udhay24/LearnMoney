var express = require('express');
var apps = express();
var bodyParser = require('body-parser');
var mongoose = require('mongoose');

apps.use(bodyParser.json);

Hack = require('./models/hack');
System=require('./models/system');

 mongoose.connect('mongodb://localhost/hack');
 var db = mongoose.connection;
 apps.get('/',function(req,res){
 	res.send('Welcome to the Hackathon!!!');
 });



 apps.get('/api/hacks',function(req,res){
   Hack.getHacks(function(err,hacks){
   	if(err){
   		throw err;
   	}
   	res.json(hacks);
   	
   });
 });


 apps.get('/api/systems',function(req,res){
   System.getSystems(function(err,systems){
   	if(err){
   		throw err;
   	}
   	res.json(systems);
   	
   });
 });


 apps.post('/api/hacks',function(req,res){
  var hack=req.body;
   Hack.addHack(hack,function(err,hack){
   	if(err){
   		throw err;
   	}
   	res.json(hack);
   	
   });
 });


 apps.post('/api/systems',function(req,res){
  var system=req.body;
   System.addSystem(system,function(err,system){
   	if(err){
   		throw err;
   	}
   	res.json(system);
   	
   });
 });


  apps.put('/api/hacks/:_id',function(req,res){
  	var id=req.params._id;
  var hack=req.body;
   Hack.updateHack(id,{},hack,function(err,hack){
   	if(err){
   		throw err;
   	}
   	res.json(hack);
   	
   });
 });


   apps.put('/api/systems/:_id',function(req,res){
  	var id=req.params._id;
  var system=req.body;
   System.updateSystem(id,{},system,function(err,system){
   	if(err){
   		throw err;
   	}
   	res.json(system);
   	
   });
 });


 apps.listen(3000);
 console.log('Running on port 3000');

