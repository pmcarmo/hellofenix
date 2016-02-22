package example;

import pt.ist.fenixframework.DomainRoot;

public class Person extends Person_Base {
    
    public  Person(String name, DomainRoot root) {
        setName(name);
        setRoot(root);
    }

    public void sayHello() {
        System.out.println("Hello, I'm " + getName() + "!");
    }

    public void remove() {
	setRoot(null);
	deleteDomainObject();
    }
}
