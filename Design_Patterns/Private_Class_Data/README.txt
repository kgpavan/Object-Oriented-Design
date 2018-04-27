

Private Class Data
------------------

Intent
------

Control write access to class attributes
Separate data from methods that use it
Encapsulate class data initialization
Providing new type of final - final after constructor


Problem
-------

A class may expose its attributes (class variables) to manipulation when manipulation is no longer desirable, e.g. after construction. Using the private class data design pattern prevents that undesirable manipulation.

A class may have one-time mutable attributes that cannot be declared final. Using this design pattern allows one-time setting of those class attributes.

The motivation for this design pattern comes from the design goal of protecting class state by minimizing the visibility of its attributes (data).

Discussion
------------------
The private class data design pattern seeks to reduce exposure of attributes by limiting their visibility.

It reduces the number of class attributes by encapsulating them in single Data object. It allows the class designer to remove write privilege of attributes that are intended to be set only during construction, even from methods of the target class.

Structure
The private class data design pattern solves the problems above by extracting a data class for the target class and giving the target class instance an instance of the extracted data class.

Scheme of Private Class Data

Check list
----------
Create data class. Move to data class all attributes that need hiding.
Create in main class instance of data class.
Main class must initialize data class through the data class's constructor.
Expose each attribute (variable or property) of data class through a getter.
Expose each attribute that will change in further through a setter.







---
layout: pattern
title: Private Class Data
folder: private-class-data
permalink: /patterns/private-class-data/
pumlid: RShR3SCm243HLTe1RFwx3S4eeSB4uf6itmpGlwkZ-nOZhS7b-ZeoLtm07E--InwrLR3JQScMdSu9edLZeiCNBso3GtPh2pFPBM1YF07BvSBaHeeHRJm_SD8VxkMphvhw0m00
categories: Other
tags:
 - Java
 - Difficulty-Beginner
 - Idiom
---

## Intent
Private Class Data design pattern seeks to reduce exposure of
attributes by limiting their visibility. It reduces the number of class
attributes by encapsulating them in single Data object.

![alt text](./etc/private-class-data.png "Private Class Data")

## Applicability
Use the Private Class Data pattern when

* you want to prevent write access to class data members
