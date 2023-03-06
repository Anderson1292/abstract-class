package entities;

public class PhysicalPerson extends People{

	private Double spending;
	
	
	public PhysicalPerson(String name, Double annualIncome, Double spending) {
		super(name, annualIncome);
		this.spending = spending;
	}
	
	public Double getEmployees() {
		return spending;
	}

	public void setEmployees(Double spending) {
		this.spending = spending;
	}

	@Override
	public Double taxCalculation() {
		// TODO Auto-generated method stub
		if(getAnnualIncome() < 20000.00) {
			return getAnnualIncome() * 0.15 - spending * 0.5;
		}
		else {
			return getAnnualIncome() * 0.25 - spending * 0.5;
		}
	}

}
