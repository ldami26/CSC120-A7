Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
- What worked, what didn't, what advice would you give someone taking this course in the future?

I overloaded the `Building` constructors to allow different combinations of parameters (like name, address, and number of floors), making it easier to create buildings with varying levels of detail. In `Cafe`, I overloaded `sellCoffee` to handle different customer orders based on cup size, sugar, and cream preferences, helping manage inventory more flexibly. In `House`, I overloaded the `moveIn` method to allow adding one or multiple residents at once, which makes it faster to add several people.

Using inheritance to share methods across subclasses made the code cleaner. Overriding and overloading made each building type flexible and adaptable to different needs. It was challenging to make sure overridden methods still used the parent class functionality without duplicating code. Understanding the basics of inheritance and method overriding early on will make working with classes much easier. Practice using `super` to avoid duplicating code, and don’t hesitate to experiment with overloading methods to see how it affects flexibility.