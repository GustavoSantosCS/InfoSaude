/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.pin.infosaude.control.excecpton;

/**
 *
 * @author lucas
 */
public class DadosVaziosExcepitions extends Exception{
    
    public DadosVaziosExcepitions(){
        super("Existem campos vazios neste formulário");
    }
    
    public DadosVaziosExcepitions(String message, Throwable cause) {
        super(message, cause);
    
    }

    public DadosVaziosExcepitions(String cpf_invalido) {
        super(cpf_invalido);
    }
    
    
}
