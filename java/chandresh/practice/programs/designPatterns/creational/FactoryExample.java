package chandresh.practice.programs.designPatterns.creational;

import java.security.InvalidParameterException;

enum EngineeringStream{
	Electrical,
	Mechanical;
}

abstract class Engineer{
	
	public Engineer(String name, EngineeringStream stream){
		this.name = name;
		this.stream = stream;
	}
	
	private String name;
	private EngineeringStream stream;
	
	public String getName() {
		return name;
	}
	public EngineeringStream getStream() {
		return stream;
	}
	
	public abstract void greet();
	 
}

class ElectricalEngineer extends Engineer{
	public ElectricalEngineer(String name){
		super(name,EngineeringStream.Electrical);
	}

	@Override
	public void greet() {
		System.out.println("Hello!! My name is "+ this.getName() +" and my stream is "+ this.getStream().name());
	}
}

class MechanicalEngineer extends Engineer{
	public MechanicalEngineer(String name){
		super(name,EngineeringStream.Mechanical);
	}

	@Override
	public void greet() {
		System.out.println("Hello!! My name is "+ this.getName() +" and my stream is "+ this.getStream().name());
	}
}

class EngineerFactory{
	public static Engineer getEngineer(String name, EngineeringStream stream){
		if(EngineeringStream.Electrical.name().equals(stream.name()))
			return new ElectricalEngineer(name);
		if(EngineeringStream.Mechanical.name().equals(stream.name()))
			return new MechanicalEngineer(name);
		
		throw new InvalidParameterException("Invalid stream");
	}
}

public class FactoryExample {

	public static void main(String args[]){
		Engineer electricalEngineer = EngineerFactory.getEngineer("Robert", EngineeringStream.Electrical);
		electricalEngineer.greet();
		
		Engineer mechanicalEngineer = EngineerFactory.getEngineer("David", EngineeringStream.Mechanical);
		mechanicalEngineer.greet();
	}
	

}
