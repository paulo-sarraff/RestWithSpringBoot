package br.com.sarraff.util;

import br.com.sarraff.converters.Conversao;
import br.com.sarraff.exception.UnsuportedMathOperationException;

public class OperacoesMatematicas {
	
	public Double soma(String numberOne, String numberTwo) {
		if(!Conversao.isNumeric(numberOne) || !Conversao.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}
		
		Double sum = Conversao.convertToDouble(numberOne) + Conversao.convertToDouble(numberTwo);
		return sum;
	}
	
	public Double subtrair(String numberOne, String numberTwo) {
		if(!Conversao.isNumeric(numberOne) || !Conversao.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}
		
		Double subtracao = Conversao.convertToDouble(numberOne) - Conversao.convertToDouble(numberTwo);
		return subtracao;
	}
	
	public Double multiplicar(String numberOne, String numberTwo) {
		if(!Conversao.isNumeric(numberOne) || !Conversao.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}
		
		Double multiplicacao = Conversao.convertToDouble(numberOne) * Conversao.convertToDouble(numberTwo);
		return multiplicacao;
	}
	
	public Double dividir(String numberOne, String numberTwo) {
		if(!Conversao.isNumeric(numberOne) || !Conversao.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}
		
		Double divisao = Conversao.convertToDouble(numberOne) / Conversao.convertToDouble(numberTwo);
		return divisao;
	}
	
	public Double media(String numberOne, String numberTwo) {
		if(!Conversao.isNumeric(numberOne) || !Conversao.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}
		
		Double media = (Conversao.convertToDouble(numberOne) + Conversao.convertToDouble(numberTwo))/2;
		return media;
	}
	
	public Double raizQuadrada(String number) {
		if(!Conversao.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value.");
		}
		
		Double raiz = Math.sqrt(Conversao.convertToDouble(number));
		return raiz;
	}
}
