import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    // Массив для хранения количества элементов в каждой строке.
    // Индекс массива = номер строки/столбца, значение - кол-во крестиков
    public static int[] rowsSumValues;
    public static int[] colsSumValues;
    // .........................................................
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            calcLinesColumnsDiags();
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void calcLinesColumnsDiags() {
        char symb;
        for (int row = 0; row < SIZE; row++) {
            int rowSum = 0;
            int colSum = 0;
            for (int col = 0; col < SIZE; col++) {
                // Проверяем строки
                symb = map[row][col];
                if (symb == DOT_X) {
                    if (row >= DOTS_TO_WIN && rowSum >= DOTS_TO_WIN - 1) {
                        // Если крестиков много, то блокируем строку
                        rowSum = SIZE;
                    } else
                        rowSum++;
                } else {
                    if (symb == DOT_O && row >= DOTS_TO_WIN && rowSum >= DOTS_TO_WIN - 1) {
                        // Если крестиков много, то блокируем строку (с учётом ноликов)
                        rowSum = SIZE;
                    }
                }
                //Проверяем столбцы
                symb = map[col][row];
                if (symb == DOT_X) {
                    if (colSum >= DOTS_TO_WIN - 1) {
                        // Если крестиков много, то блокируем столбец
                        colSum = SIZE;
                    } else
                        colSum++;
                } else {
                    if (symb == DOT_O && col >= DOTS_TO_WIN && colSum >= DOTS_TO_WIN - 1) {
                        // Если крестиков много, то блокируем столбец (с учётом ноликов)
                        colSum = SIZE;
                    }
                }
            }
            rowsSumValues[row] = rowSum;
            colsSumValues[row] = colSum;
        }
    }

    public static boolean checkWin(char symb) {
        // Проверка горизонтали и вертикали
        for (int row = 0; row < SIZE; row++) {
            int cntSymbInRow = 0;
            int cntSymbInCol = 0;

            for (int col = 0; col < SIZE; col++) {
                // Проверка горизонтали
                if (map[row][col] == symb) {
                    cntSymbInRow++;
                } else {
                    cntSymbInRow = 0;
                }
                // Проверка вертикали
                if (map[col][row] == symb) {
                    cntSymbInCol++;
                } else {
                    cntSymbInCol = 0;
                }

                if (cntSymbInRow >= DOTS_TO_WIN || cntSymbInCol >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        // Проверка всех диагональных направлений
        for (int row = 0; row < SIZE; row++) {
            // Проверка включает главную и побочную диагонали
            int cntSymbInDiag1 = 0;
            int cntSymbInDiag2 = 0;
            for (int col = 0; col < SIZE - row; col++) {
                // Проверка диагонали 1
                if (map[row + col][col] == symb) {
                    cntSymbInDiag1++;
                } else {
                    cntSymbInDiag1 = 0;
                }
                // Проверка диагонали 2
                if (map[row + col][SIZE - col - 1] == symb) {
                    cntSymbInDiag2++;
                } else {
                    cntSymbInDiag2 = 0;
                }
                if (cntSymbInDiag1 >= DOTS_TO_WIN || cntSymbInDiag2 >= DOTS_TO_WIN) {
                    return true;
                }

            }
        }

        for (int row = 0; row < SIZE; row++) {
            // Проверка исключает главную и побочную диагонали
            int cntSymbInDiag1 = 0;
            int cntSymbInDiag2 = 0;
            for (int col = 0; col < SIZE - row - 1; col++) {
                // Проверка диагонали 3
                if (map[col + row][col + 1] == symb) {
                    cntSymbInDiag1++;
                } else {
                    cntSymbInDiag1 = 0;
                }
                // Проверка диагонали 4
                if (map[col + row][SIZE - col - 2] == symb) {
                    cntSymbInDiag2++;
                } else {
                    cntSymbInDiag2 = 0;
                }
                if (cntSymbInDiag1 >= DOTS_TO_WIN || cntSymbInDiag2 >= DOTS_TO_WIN) {
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;

        do {
            int[] rowIdx;
            rowIdx = getColRowIdxForBlock();
            y = rowIdx[0];
            x = rowIdx[1];
            if (x < 0 || y < 0) {
                // Если не нашлись варианты для блокировки, то ходим рандомно
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            }
        } while (!isCellValid(x, y));

        System.out.println("Компьютер сделал ход в " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    // Метод блокировки хода пользователя.
    // Блокировка срабатывает на предпоследнем шаге пользователя (при кол-ве крестиков = DOTS_TO_WIN - 1).
    // Анализируется горизонтальное и вертикальное направления. По диагоналям анализ не выполняется
    private static int[] getColRowIdxForBlock() {
        int[] retArr = {-1, -1};
        // Находим строку для блокировки
        for (int i = 0; i < SIZE; i++) {
            if (rowsSumValues[i] >= DOTS_TO_WIN - 1) {
                retArr[0] = i;
                break;
            }
        }
        if (retArr[0] > -1) {
            // Находим свободную точку, учитывая направление
            for (int i = 0; i < SIZE; i++) {
                if (map[retArr[0]][i] == DOT_EMPTY) {
                    if ((i < SIZE - 1 && map[retArr[0]][i + 1] != DOT_EMPTY) || (i > 0 && map[retArr[0]][i - 1] != DOT_EMPTY)) {
                        retArr[1] = i;
                        break;
                    }

                }
            }

        }

        if (retArr[0] == -1 || retArr[1] == -1) {
            retArr[0] = -1;
            retArr[0] = -1;
            // Находим столбец для блокировки
            for (int i = 0; i < SIZE; i++) {
                if (colsSumValues[i] >= DOTS_TO_WIN - 1) {
                    retArr[1] = i;
                    break;
                }
            }
            if (retArr[1] > -1) {
                // Находим свободную точку, учитывая направление
                for (int i = 0; i < SIZE; i++) {
                    if (map[i][retArr[1]] == DOT_EMPTY) {
                        if ((i < SIZE - 1 && map[i + 1][retArr[1]] != DOT_EMPTY) || (i > 0 && map[i - 1][retArr[1]] != DOT_EMPTY)) {
                            retArr[0] = i;
                            break;
                        }

                    }
                }

            }
        }

        return retArr;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        rowsSumValues = new int[SIZE];
        colsSumValues = new int[SIZE];
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}