database {
	
	username='thedude'
	driver='org.h2.Driver'
	schema='demo'

}


environments {

    local {

	database {
		url = 'jdbc:h2:tcp://localhost:9392/demo'
		password = 'secret'
	    }
	}

    dev {

	database {
		url = 'jdbc:h2:tcp://xxxxxxxx'
		password = 'secret'
	    }    
	}
}





