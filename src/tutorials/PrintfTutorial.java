package tutorials;

// You can find the details here
// https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
public class PrintfTutorial {
    public static void main(String[] args) {
        // You can align your format like this
        //     0      1      2      3      4      5      6      7      8      9     10
        //   A[1]  B[20]   C[3]  D[40]   E[5]   F[7]   G[0]   H[7]   I[9]  J[10]  K[88]
        String[] names = {"A[1]", "B[20]", "C[3]", "D[40]", "E[5]", "F[7]", "G[0]", "H[7]", "I[9]", "J[10]", "K[88]"};
        for (int i = 0; i < names.length; i++) {
            // specify the width=2 to accommodate different numbers of digits
            System.out.printf("   %2d  ", i);
        }
        System.out.println();
        for (String name : names) {
            // specify the width=5 to accommodate different lengths of strings
            System.out.printf(" %5s ", name);
        }
        System.out.println();


        // Print numbers and strings
        int id = 20;
        String name = "Waterball";
        System.out.printf("My id: %d, My Name: %s\n", id, name); // My id: 20, My Name: Waterball\n

        // Print floats and doubles
        float a = 14.12345f;
        double b = 14.1234567890123456;
        // write %.2f/%.7f to round up to the second/seventh decimal place
        System.out.printf("A: %.2f, B: %.7f\n", a, b);  // A: 14.12, B: 14.1234568\n
        // Scientific notation
        System.out.printf("A: %e, B: %e\n", a, b); // A: 1.412345e+01, B: 1.412346e+01
        System.out.printf("A: %g, B: %g\n", a, b); // A: 1.412345e+01, B: 1.412346e+01


        // Argument index
        // You can specify the argument index as %<index>$<notation>
        System.out.printf("%5$d, %4$d, %3$d, %2$d, %1$d\n", 1, 2, 3, 4, 5); // 5, 4, 3, 2, 1\n
    }
}
