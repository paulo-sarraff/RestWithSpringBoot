package br.com.sarraff;


import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Startup {

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
		
		/*BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
		String result = bCryptPasswordEncoder.encode("sarraff123");
		System.out.println("My hash " + result);*/
		
		//Integer[] numeros = {4, 2, 3, 7, 2, 4, 2};
		
		//Scanner scanner = new Scanner(System.in);
		//int myInt = scanner.nextInt();
		//scanner.close();
		
		//encontrar em um vetor um subvetor com o valor informado pelo usuário
		//calcularSomaVetor(numeros, myInt);
		
		//dado um vetor a que possui somente números positivos de 1 até a.length. 
			//encontrar a primeira ocorrência duplicada de um dado número.
				//caso encontre mais de um número duplicado, deve ser priorizado o que a segunda ocorrência ocorre primeiro.
		//Integer[] v = {2, 1, 3, 2, 3, 5};
		//System.out.println(encontrarPosicaoDuplicadaVetor(v));
	}
	
	
	private static Integer encontrarPosicaoDuplicadaVetor(Integer[] numeros) {
		HashSet<Integer> ja_apareceram = new HashSet<Integer>();
		for (int i = 0; i < numeros.length; i++) {
			if(ja_apareceram.contains(numeros[i])) {
				return numeros[i];
			}
			ja_apareceram.add(numeros[i]);
		}
		return -1;
	}


	private static boolean calcularSomaVetor(Integer[] numeros, int myInt) {
		int soma_atual = 0;
		int inicio = 0;
		// {1, 2, 3, 5, 7, 8, 12, 15};
		for (int fim = 0; fim < numeros.length; fim++) {
			soma_atual += numeros[fim];
			while (soma_atual > myInt && inicio < fim) {
				soma_atual -= numeros[inicio];
				inicio++;
			}
			
			if(soma_atual == myInt) {
				System.out.println((inicio+1) + " " + (fim+1));
				return true;
			}
		}
		System.out.println("-1");
		return false;
	}
	
}