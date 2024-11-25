/**
 * Пакет Testlab.
 */
package Testlab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Класс {@code trylab} реализует программу для работы с квадратной матрицей,
 * которая заполняется заданным символом, с сохранением результатов в текстовый файл.
 */
public class Trylab
{

    /**
     * Главный метод программы.
     * 
     * @param args аргументы командной строки, не используются в данной программе.
     * @throws FileNotFoundException если файл для записи результатов не может быть создан.
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) throws FileNotFoundException 
    {
        // Объявление переменных
        int amnt_row; // Размер квадратной матрицыc
        char[][] mtrx; // Матрица для заполнения символами

        String filler; // Символ-заполнитель для матрицы
        Scanner in = new Scanner(System.in); // Сканер для чтения пользовательского ввода
        File dataFile = new File("MyFile.txt"); // Файл для записи результатов
        PrintWriter fout = new PrintWriter(dataFile); // Объект для записи данных в файл

        // Считывание размера матрицы
        System.out.print("Введіть розмір квадратної матриці: ");
        amnt_row = in.nextInt();
        in.nextLine(); // Очистка буфера

        // Инициализация матрицы
        mtrx = new char[amnt_row][];
        for (int i = amnt_row - 1; i >= 0; i--) 
        {
            mtrx[i] = new char[amnt_row];
        }

        // Считывание символа-заполнителя
        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();

        // Заполнение матрицы
        exit:
        for (int i = 0; i < amnt_row; i++)
        {
            for (int j = 0; j < amnt_row; j++) 
            {
                if (filler.length() == 1) { // Проверка длины символа-заполнителя
                    if (i == 0 || i == amnt_row - 1 || j == 0 || j == amnt_row - 1) 
                    {
                        mtrx[i][j] = ' '; // Пробелы по краям
                    } 
                    else
                    {
                        mtrx[i][j] = (char) filler.codePointAt(0); // Внутреннее заполнение
                    }
                    System.out.print(mtrx[i][j] + " ");
                    fout.print(mtrx[i][j] + " ");
                } 
                else if (filler.length() == 0)
                { // Если не введен символ
                    System.out.print("\nНе введено символ заповнювач");
                    break exit;
                } 
                else
                { // Если введено больше одного символа
                    System.out.print("\nЗабагато символів заповнювачів");
                    break exit;
                }
            }
            System.out.print("\n");
            fout.print("\n");
        }

        // Завершение работы с файлом
        fout.flush();
        fout.close();
    }
}
