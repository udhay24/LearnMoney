var mongoose = require('mongoose');

var systemSchema=mongoose.Schema({
	title:{
		type: String,
		required: true

	},
	create_date:{
		type:Date,

		default:Date.now

	}

});

var System= module.exports =mongoose.model('System',systemSchema);

module.exports.getSystems=function(callback,limit){
	System.find(callback).limit(limit);
}
	//add system
	module.exports.getSystem=function(system,callback){
	System.create(system,callback);
}

//update hack
	module.exports.updateSystem=function(id,options,system,callback){
		var query ={id:id};
		var update={
			title:system.title
		}

	System.findOneAndUpdate(query,options,update,callback);

}


   	