package general;

import java.util.ArrayList;
import java.util.List;

public class CloneShallowCopyDemo
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Person p = new Person(1, "XYZ");
        Pet pet1 = new Pet("Honey");
        Pet pet2 = new Pet("Browny");
        p.favPet = pet1;

        p.pets.add(pet1);
        p.pets.add(pet2);

        System.out.println(p);
        System.out.println("After cloned");

        Person p2 = (Person) p.clone();

        System.out.println(p2);

        p.name = "ABC";
        p.favPet.name = "Jill";
        System.out.println("Changing p person name and pet name " + p);

        System.out.println("After changed");

        System.out.println(p2);

    }
}

class Person implements Cloneable
{
    int id;
    String name;
    List<Pet> pets = new ArrayList<>();
    Pet favPet ;


    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pets=" + pets +
                ", favPet=" + favPet + this.hashCode() +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        Person thisObj = (Person) super.clone();
        thisObj.favPet = (Pet) favPet.clone();
        return thisObj;
    }
}

class Pet implements Cloneable
{
    String name;

    public Pet(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Pet{" +
                "name='" + name + '\'' + this.hashCode() +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}


