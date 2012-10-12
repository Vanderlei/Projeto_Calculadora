package br.faccamp.domain;

import br.faccamp.view.CalculadoraGUI;

public class Display {

	private CalculadoraGUI gui;

	private double result; // resultado das operações
	private double n1; // 1º valor salvo
	private double n2;// 2º valor salvo
	private double mm;// valor usado para gravar +-
	private double memo;// valor usado para guardar a memória
	private boolean limpar = false; // verificador usado para saber se o Display
									// deverá ser limpo ou não

	public Display(CalculadoraGUI gui) {
		this.gui = gui;
	}

	public double getMemo() {
		return memo;
	}

	public void setMemo(double memo) {
		this.memo = memo;
		gui.mostraM();
	}

	public double getMm() {
		return mm;
	}

	public void setMm(double mm) {
		this.mm = mm;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public double getN1() {
		return n1;
	}

	public void setN1(double n1) {
		this.n1 = n1;
	}

	public double getN2() {
		return n2;
	}

	public void setN2(double n2) {
		this.n2 = n2;
	}

	public boolean isLimpar() {
		return limpar;
	}

	public void setLimpar(boolean limpar) {
		this.limpar = limpar;
	}

	public void atualiza(String texto) {

		if (getConteudo().equalsIgnoreCase("")) {
			gui.atualizaDisplay(texto);
		} else {
			if (limpar == false) {
				gui.atualizaDisplay((getConteudo() + texto));
			} else {
				gui.atualizaDisplay(null);
				gui.atualizaDisplay(texto);
				limpar = false;
			}
		}

	}

	public String getConteudo() {
		return gui.getDisplay();
	}

	// Conta o número de digitos que o Display possui
	// caso seja um digito, e esse digito seja zera
	// ele nao permite adcionar um outro zero.
	// caso seja outro número, ele atualiza normalmente.
	public void comparaZero(String texto) {
		if ((getConteudo().equalsIgnoreCase("0"))
				&& (gui.getDisplay().length() == 1)) {
			gui.atualizaDisplay("0");

		} else {
			if (limpar == false) {
				gui.atualizaDisplay((getConteudo() + texto));
			} else {
				gui.atualizaDisplay(null);
				gui.atualizaDisplay(texto);
				limpar = false;
			}
		}
	}

	public void salva1() {
		// Metodo usado dentro das operações, assim que uma operação
		// é selecionada, o número que está no display é salvo em n1
		// e o display fica limpo para receber o proximo numero
		n1 = Double.parseDouble(gui.getDisplay());
	}

	public void salvaMM() {
		mm = Double.parseDouble(gui.getDisplay());
	}

	public void salva2() {
		n2 = Double.parseDouble(gui.getDisplay());

	}

	public void calcula() {
		n1 = getN1();
		salva2();
		n2 = getN2();
		switch (Calculadora.getOper()) {
		case '+':
			result = n1 + n2;
			setResult(result);
			String s = Double.toString(getResult());
			gui.atualizaDisplay(s);
			setLimpar(true);
			break;
		case '-':
			result = n1 - n2;
			s = Double.toString(result);
			gui.atualizaDisplay(s);
			setLimpar(true);
			break;
		case '*':
			result = n1 * n2;
			s = Double.toString(result);
			gui.atualizaDisplay(s);
			setLimpar(true);
			break;
		case '/':
			if (n2 == 0) {
				gui.atualizaDisplay("Erro - Divisão por 0");
				setLimpar(true);
			} else {
				result = n1 / n2;
				s = Double.toString(result);
				gui.atualizaDisplay(s);
				setLimpar(true);
			}
			break;
		case '^':
			result = Math.pow(n1, n2);
			s = Double.toString(result);
			gui.atualizaDisplay(s);
			setLimpar(true);
			break;
		case '%':
			result = n1 * n2 / 100;
			s = Double.toString(result);
			gui.atualizaDisplay(s);
			setLimpar(true);
			break;
		case 'R':
			result = Math.sqrt(n1);
			s = Double.toString(result);
			gui.atualizaDisplay(s);
			setLimpar(true);
			break;

		}
	}

}
