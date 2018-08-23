
CONVERTER DESIGN PATTERN 
————————————————————————

## Intent
—————————

The purpose of the Converter Pattern is to provide a generic, common way of bidirectional conversion between corresponding types, allowing a clean implementation in which the types do not need to be aware of each other. Moreover, the Converter Pattern introduces bidirectional collection mapping, reducing a boilerplate code to minimum.


## Applicability
----------------

Use the Converter Pattern in the following situations:

i. When you have types that logically correspond which other and you need to convert entities between them

ii. When you want to provide different ways of types conversions depending on a context

iii. Whenever you introduce a DTO (Data transfer object), you will probably need to convert it into the domain equivalence
