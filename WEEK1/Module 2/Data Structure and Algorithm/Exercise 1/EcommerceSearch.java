import java.util.Arrays; 
 
public class EcommerceSearch { 
     
    static class Product implements Comparable<Product> { 
        String id; 
        String name; 
        String category; 
         
        public Product(String id, String name, String category) { 
            this.id = id; 
            this.name = name; 
            this.category = category; 
        } 
         
        @Override 
        public int compareTo(Product other) { 
            return this.id.compareTo(other.id); 
        } 
    } 
 
    public static void main(String[] args) { 
      
        Product[] products = { 
            new Product("P100", "Laptop", "Electronics"), 
            new Product("P200", "Phone", "Electronics"), 
            new Product("P300", "Chair", "Furniture") 
        }; 
         
         
        Product[] sortedProducts = Arrays.copyOf(products, products.length); 
        Arrays.sort(sortedProducts); 
         
        
        String searchId = "P200"; 
         
        System.out.println("Linear Search Results:"); 
        Product linearResult = linearSearch(products, searchId); 
        System.out.println(linearResult != null ? "Found: " + linearResult.name : "Not found"); 
       
        System.out.println("\nBinary Search Results:"); 
        Product binaryResult = binarySearch(sortedProducts, searchId); 
        System.out.println(binaryResult != null ? "Found: " + binaryResult.name : "Not found"); 
    } 
     
    
    public static Product linearSearch(Product[] products, String id) { 
        for (Product p : products) { 
            if (p.id.equals(id)) { 
                return p; 
            } 
        } 
        return null; 
    } 
     
     
    public static Product binarySearch(Product[] products, String id) { 
        int left = 0; 
        int right = products.length - 1; 
         
        while (left <= right) { 
            int mid = left + (right - left) / 2; 
            int comparison = products[mid].id.compareTo(id); 
             
            if (comparison == 0) { 
                return products[mid]; 
            } else if (comparison < 0) { 
                left = mid + 1; 
            } else { 
                right = mid - 1; 
            } 
        } 
        return null; 
    } 
} 