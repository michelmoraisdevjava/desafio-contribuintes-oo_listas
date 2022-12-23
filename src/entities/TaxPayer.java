package entities;

public class TaxPayer {

	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;

	public TaxPayer() {
	}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax(double monthlyIncome) {
		monthlyIncome = salaryIncome / 12.0;
		if (monthlyIncome > 5000.00) {
			return 0.2 * salaryIncome;
		} else if (monthlyIncome < 3000.00) {
			return 0.0;
		} else {
			return 0.1 * salaryIncome;
		}
	}
	
	public double servicesTax() {
		return servicesIncome * 0.15;
	}
	
	public double capitalTax() {
		return capitalIncome * 0.2;
	}
	
	public double grossTax() {
		double monthlyIncome = 0;
		return salaryTax(monthlyIncome) + servicesTax() + capitalTax();
	}
	
	public double taxRebate(double maximumDeductible, double expensesDeductible) {
		maximumDeductible = 0.3 * grossTax();
		expensesDeductible = healthSpending + educationSpending;
		if(expensesDeductible < maximumDeductible) {
			return expensesDeductible;
		}else {
			return maximumDeductible;
		}
	}
	
	public double netTax() {
		double maximumDeductible = 0;
		double expensesDeductible = 0;
		return grossTax() - taxRebate(maximumDeductible, expensesDeductible);
	}
	
	public String toString() {
		double maximumDeductible = 0;
		double expensesDeductible = 0;
		return "Imposto bruto total: "
				+ String.format("%.2f%n", grossTax())
				+ "Abatimento: "
				+ String.format("%.2f%n", taxRebate(maximumDeductible, expensesDeductible))
				+ "Imposto devido: "
				+ String.format("%.2f%n", netTax());
		
	}
	
}
