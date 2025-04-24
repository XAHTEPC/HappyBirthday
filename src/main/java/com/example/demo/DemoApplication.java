package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите номер квадрата (1-30) для изменения цвета (q для выхода):");

		while (true) {
			String input = scanner.nextLine();
			if ("q".equalsIgnoreCase(input)) break;

			try {
				int num = Integer.parseInt(input);
				SquareController.changeColorFromConsole(num);
			} catch (NumberFormatException e) {
				System.out.println("Введите число от 1 до 30 или q для выхода");
			}
		}
		scanner.close();
	}
}