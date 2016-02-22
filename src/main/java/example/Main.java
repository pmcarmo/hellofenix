package example;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.DomainRoot;
import pt.ist.fenixframework.FenixFramework;

public class Main {

    // FenixFramework will try automatic initialization when first accessed
    public static void main(String [] args) {
            addNewPeople(args);
            greetAll();
    }

    @Atomic
    public static void addNewPeople(String[] args) {
        DomainRoot root = FenixFramework.getDomainRoot();
        for (String name : args)
	    if (name.charAt(0) == '-')
		removePeople(name.substring(1));
	    else
		new Person(name, root);
    }

    @Atomic
    public static void greetAll() {
        DomainRoot root = FenixFramework.getDomainRoot();
        for (Person p : root.getPeopleSet()) p.sayHello();
    }

    public static void removePeople(String name) {
        DomainRoot root = FenixFramework.getDomainRoot();
        for (Person p : root.getPeopleSet())
	    if (name.equals(p.getName())) {
		// root.getPeopleSet().remove(p);
		p.remove();
	    	return;
	    }
	System.out.println(name + ": not in set (can not remove)");
    }
}
