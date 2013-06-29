package com.berico.clavin.examples;

import com.berico.clavin.GeoParser;
import com.berico.clavin.GeoParserFactory;
import com.berico.clavin.extractor.CoordinateOccurrence;
import com.berico.clavin.resolver.ResolutionContext;
import com.berico.clavin.resolver.ResolvedCoordinate;

/*#####################################################################
 * 
 * CLAVIN (Cartographic Location And Vicinity INdexer)
 * ---------------------------------------------------
 * 
 * Copyright (C) 2012-2013 Berico Technologies
 * http://clavin.bericotechnologies.com
 * 
 * ====================================================================
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 * 
 * ====================================================================
 * 
 * GeoHashDemo.java
 * 
 *###################################################################*/

/**
 * Demonstrates using the customer Coordinate Parser.
 */
public class GeoHashDemo {
	
	public static void main(String[] args) throws Exception {
		
		// Register the new Parsing Strategy.
		GeoParserFactory
			.DefaultCoordinateParsingStrategies
				.add(new GeoHashParsingStrategy());
		
		// Get a parser instance.
		GeoParser parser = GeoParserFactory.getDefault("IndexDirectory/");
		
		// Parse the document.
		ResolutionContext results = 
			parser.parse("Hey mom, I went to geo:u4pruydqqvjs today!");
		
		// Get the CoordinateOccurrence from the Extraction Context
		CoordinateOccurrence<?> ecoord = 
				results.getExtractionContext().getCoordinates().get(0);
		
		System.out.println(ecoord);
		
		// Get the ResolvedCoordinate from the results
		ResolvedCoordinate rcoord = results.getCoordinates().get(0);
		
		System.out.println(rcoord);
	}
}
