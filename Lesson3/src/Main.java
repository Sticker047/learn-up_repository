class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1 (Массив)");
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = (int) (Math.random() * 10);

            System.out.print(array[i] + " ");
        }
        System.out.println("\nСумма равна " + Sum(array));
        System.out.println(Sum(array) % 2 == 0 ? "ЧЕТНО" : "НЕ ЧЕТНО");

        System.out.println("\nЗадание 2 (Игра \"Жизнь\")");
        int[][] matrix = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = (int) (Math.random() * 2);

            }
        }
        PrintMatrix(matrix);
        int counterStep = 5;
        for (int i = 0; i < counterStep; i++) {
            System.out.println("\n\n" + (i + 1) + " шаг");
            matrix = Step(matrix);
            PrintMatrix(matrix);
        }
    }

    public static int Sum(int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) res += array[i];
        return res;
    }

    public static int[][] Step(int[][] matrix) {
        int[][] matrix2 = new int[10][10];
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                if
                (getNumberOfNeighbors(matrix, i, j) == 2) matrix2[i][j] = 1;
                else if (getNumberOfNeighbors(matrix, i, j) == 3) matrix2[i][j] = 1;
                else matrix2[i][j] = 0;
            }
        return matrix2;
    }

    public static int getNumberOfNeighbors(int[][] matrix, int x, int y) {
        int res = 0;
        switch (x) {
            case 0:
                res += matrix[1][y];
                res += matrix[9][y];
                break;
            case 9:
                res += matrix[8][y];
                res += matrix[0][y];
                break;
            default: {
                res += matrix[x - 1][y];
                res += matrix[x + 1][y];
            }
            break;
        }

        switch (y) {
            case 0:
                res += matrix[x][1];
                res += matrix[x][9];
                break;
            case 9:
                res += matrix[x][8];
                res += matrix[x][0];
                break;
            default: {
                res += matrix[x][y + 1];
                res += matrix[x][y - 1];
            }
        }

        if (x == 0 && y == 0)
        {
            res += matrix[9][1];
            res += matrix[1][1];
            res += matrix[1][9];
            res += matrix[9][9];
        }

        if (x == 0 && y == 9)
        {
            res += matrix[1][8];
            res += matrix[1][0];
            res += matrix[9][0];
            res += matrix[9][8];
        }

        if (x == 9 & y == 0)
        {
            res += matrix[0][9];
            res += matrix[0][1];
            res += matrix[8][1];
            res += matrix[8][9];
        }

        if (x == 9 && y == 9)
        {
            res += matrix[0][8];
            res += matrix[0][0];
            res += matrix[8][0];
            res += matrix[0][8];
        }

        if (x >= 1 && y >= 1)
            res += matrix[x - 1][y - 1];
        if (x <= 8 && y <= 8) res += matrix[x + 1][y + 1];
        if (x >= 1 && y <= 8) res += matrix[x - 1][y + 1];
        if (x <= 8 && y >= 1) res += matrix[x + 1][y - 1];
        return res;
    }

    public static void PrintMatrix(int[][] matrix) {
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
