public class SimpleFinancialForecast { 
public static double calculateFutureValue(double currentValue,  double growthRate,int years)  
{ 
if (years == 0) { 
return currentValue; 
} 
double nextValue = currentValue * (1 + growthRate); 
return calculateFutureValue(nextValue, growthRate, years - 1); 
} 
public static void main(String[] args) { 
double initialAmount = 1000.0;  
double annualRate = 0.05;        
int investmentYears = 10;       
double result = calculateFutureValue(initialAmount, annualRate, investmentYears); 
System.out.println("Simple Financial Forecast"); 
System.out.println("------------------------"); 
System.out.printf("Initial amount: $%.2f%n", initialAmount); 
System.out.printf("Annual growth rate: %.1f%%%n", annualRate * 100); 
System.out.printf("Investment period: %d years%n", investmentYears); 
System.out.printf("Future value: $%.2f%n", result); 
} 
}