package br.com.sarraff.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sarraff.exception.UnsuportedMathOperationException;
import br.com.sarraff.util.OperacoesMatematicas;

@RestController
public class MathController {
	
	OperacoesMatematicas operacoes = new OperacoesMatematicas();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws UnsuportedMathOperationException {
		return operacoes.soma(numberOne, numberTwo);
	}

	@RequestMapping(value="/subtrair/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtrair(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws UnsuportedMathOperationException {
		return operacoes.subtrair(numberOne, numberTwo);
	}
	
	@RequestMapping(value="/multiplicar/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplicar(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws UnsuportedMathOperationException {
		return operacoes.multiplicar(numberOne, numberTwo);
	}	

	@RequestMapping(value="/dividir/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double dividir(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws UnsuportedMathOperationException {
		return operacoes.dividir(numberOne, numberTwo);
	}

	@RequestMapping(value="/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws UnsuportedMathOperationException {
		return operacoes.media(numberOne, numberTwo);
	}
	
	@RequestMapping(value="/raizQuadrada/{number}", method = RequestMethod.GET)
	public Double raiz(@PathVariable("number") String number) throws UnsuportedMathOperationException {
		return operacoes.raizQuadrada(number);
	}
}
