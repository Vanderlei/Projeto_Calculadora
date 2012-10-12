package br.faccamp.domain;

import br.faccamp.view.CalculadoraGUI;

public class Calculadora {

	private CalculadoraGUI gui;
	private boolean virg = false;
	private static char oper;
	private Display d;

	public Calculadora() {

		gui = new CalculadoraGUI(this);
		d = new Display(gui);
	}

	public static char getOper() {
		return oper;
	}

	public void setOper(char oper) {
		Calculadora.oper = oper;
	}

	public void trocaVirg() {
		// Método usado para bloquear
		// o uso de mais de uma virgula por dígito
		if (virg == true)
			this.virg = false;

	}

	public void processaMC() {
		// limpa a memoria
		d.setMemo(0);
		gui.escondeM();

	}

	public void processaMR() {
		// recupera o valor que esta na memória
		String s = Double.toString(d.getMemo());
		gui.atualizaDisplay(s);
		d.setLimpar(true);

	}

	public void processaMS() {
		// salva um valor na memoria
		d.setMemo(Double.parseDouble(gui.getDisplay()));
		gui.mostraM();
		d.setLimpar(true);

	}

	public void processaMMais() {
		// soma o valor que está no display
		// com o valor que já está na memória
		d.setMemo(Double.parseDouble(gui.getDisplay()) + d.getMemo());
		if (d.getMemo() != 0) {
			gui.mostraM();
		} else {
			gui.escondeM();
		}
		d.setLimpar(true);
	}

	public void processaMMenos() {
		// subtrai o valor que está no display
		// com o valor que já está na memória
		d.setMemo(d.getMemo() - Double.parseDouble(gui.getDisplay()));
		if (d.getMemo() != 0) {
			gui.mostraM();
		} else {
			gui.escondeM();
		}
		d.setLimpar(true);
	}

	public void processaCE() {
		d.setLimpar(true);
		d.atualiza(Double.toString(d.getN1()));
		setOper(' ');

	}

	public void processaC() {
		d.setLimpar(true);
		d.atualiza(null);
		d.setResult(0);
		d.setN2(0);
		d.setN1(0);
		d.setLimpar(false);
		d.setMemo(0);
		gui.escondeM();

	}

	public void processaRaiz() {
		d.salva1();
		double resultado = Math.sqrt(d.getN1());
		String s = Double.toString(resultado);
		gui.atualizaDisplay(s);
		d.setLimpar(true);

	}

	public void processaMaisOuMenos() {
		trocaVirg();
		d.salvaMM();
		d.setLimpar(true);
		if (d.getMm() > 0) {
			double teste = d.getMm() - d.getMm() - d.getMm();
			String s = Double.toString(teste);
			gui.atualizaDisplay(s);
		} else if (d.getMm() < 0) {
			double teste = d.getMm() - d.getMm() - d.getMm();
			String s = Double.toString(teste);
			gui.atualizaDisplay(s);
		}
	}

	public void processaFatorial() {
		d.salva1();
		d.setLimpar(true);
		double resultado = d.getN1();
		if (d.getN1() > 1) {
			double i = d.getN1();
			while (i != 1) {
				resultado = resultado * (i - 1);
				i--;
			}
			String s = Double.toString(resultado);
			gui.atualizaDisplay(s);
		} else {
			d.atualiza("O número deve ser maior do que 1");
			d.setLimpar(true);
		}

	}

	public void processaSete() {
		d.atualiza("7");
		d.salva2();
	}

	public void processaOito() {
		d.atualiza("8");
		d.salva2();
	}

	public void processaNove() {
		d.atualiza("9");
		d.salva2();
	}

	public void processaDivisao() {
		trocaVirg();
		setOper('/');
		d.salva1();
		d.setLimpar(true);
		String s = Character.toString(oper);
		gui.atualizaDisplay(s);

	}

	public void processaPorcentual() {
		trocaVirg();
		setOper('%');
		d.salva1();
		d.setLimpar(true);
		String s = Character.toString(oper);
		gui.atualizaDisplay(s);

	}

	public void processaQuatro() {
		d.atualiza("4");
		d.salva2();

	}

	public void processaCinco() {
		d.atualiza("5");
		d.salva2();
	}

	public void processaSeis() {
		d.atualiza("6");
		d.salva2();
	}

	public void processaVezes() {
		trocaVirg();
		setOper('*');
		d.salva1();
		d.setLimpar(true);
		String s = Character.toString(oper);
		gui.atualizaDisplay(s);

	}

	public void processaUmSobreX() {
		trocaVirg();
		d.salva1();
		d.setLimpar(true);
		double result = 1 / d.getN1();
		String s = Double.toString(result);
		gui.atualizaDisplay(s);
	}

	public void processaUm() {
		d.atualiza("1");

	}

	public void processaDois() {
		d.atualiza("2");

	}

	public void processaTres() {
		d.atualiza("3");

	}

	public void processaMenos() {
		trocaVirg();
		setOper('-');
		d.salva1();
		d.setLimpar(true);
		String s = Character.toString(oper);
		gui.atualizaDisplay(s);
	}

	public void processaXElevadoY() {
		trocaVirg();
		setOper('^');
		d.salva1();
		d.setLimpar(true);
		String s = Character.toString(oper);
		gui.atualizaDisplay(s);
	}

	public void processaZero() {
		d.comparaZero("0");
		// d.setLimpar(true);
	}

	public void processaVirgula() {
		if (virg == false) {
			d.setLimpar(false);
			d.atualiza(".");
			virg = true;
		}
	}

	public void processaIgual() {
		d.calcula();
	}

	public void processaLog() {
		d.salva1();
		double nume = Math.log10(d.getN1());
		String s = Double.toString(nume);
		gui.atualizaDisplay(s);
		d.setLimpar(true);

	}

	public void processaMais() {
		trocaVirg();
		setOper('+');
		d.salva1();
		d.setLimpar(true);
		String s = Character.toString(oper);
		gui.atualizaDisplay(s);
	}

}
