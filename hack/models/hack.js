var mongoose = require('mongoose');

var hackSchema=mongoose.Schema({
	name:{
		type: String,
		required: true

	},
	create_date:{
		type:Date,

		default:Date.now

	}

});

var Hack= module.exports =mongoose.model('Hack',hackSchema);

module.exports.getHacks=function(callback,limit){
	Hack.find(callback).limit(limit);
}

//add hack
	module.exports.getHack=function(hack,callback){
	Hack.create(hack,callback);
}


//update hack
	module.exports.updateHack=function(id,options,hack,callback){
		var query ={id:id};
		var update={
			name:hack.name
		}

	Hack.findOneAndUpdate(query,options,update,callback);

}        	