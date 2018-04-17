package com.javacodegeeks.patterns.flyweightpattern;

import java.util.HashMap;
import java.util.Map;

/*
But sometimes too many objects can slow things down. Too many objects might consume a 
large piece of memory and can slow down the application or even cause out of memory 
problems. As a good programmer, one should keep track of instantiated objects and control 
the object creation in an application. This is especially true, when we have a lot of 
similar objects and two objects from the pool don’t have much differences between them.

Sometimes the objects in an application might have great similarities and be of a similar 
kind (a similar kind here means that most of their properties have similar values and only 
a few of them vary in value). In case they are also heavy objects to create, they should 
be controlled by the application developer. Otherwise, they might consume much of the 
memory and eventually slow down the whole application.

The Flyweight Pattern is designed to control such kind of object creation and provides 
you with a basic caching mechanism. It allows you to create one object per type (the 
type here differs by a property of that object), and if you ask for an object with the 
same property (already created), it will return you the same object instead of creating 
a new one.

i. Use sharing to support large numbers of fine-grained objects efficiently.
ii. The Motif GUI strategy of replacing heavy-weight widgets with light-weight gadgets.
*/

public final class PlatformFactory {
	
	private static Map<String, Platform> map = new HashMap<>();
	private PlatformFactory(){
		throw new AssertionError("Cannot instantiate the class");
	}
	
	public static synchronized Platform getPlatformInstance(String platformType){
		Platform platform = map.get(platformType);

		if(platform==null){
			switch(platformType){
				case "C" : platform = new CPlatform(); 
						   break;
				case "CPP" : platform = new CPPPlatform(); 
				   		   break;
				case "JAVA" : platform = new JavaPlatform(); 
				   		   break;
				case "RUBY" : platform = new RubyPlatform(); 
				   		   break;   		   
			}
			map.put(platformType, platform);
		}
		return platform;
	}

}
