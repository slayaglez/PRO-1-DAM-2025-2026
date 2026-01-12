/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clases con herencias que trabajan con cartas, destinatarios y numeros de paginas
 */
package com.docencia.herencia.ejercicio14;

public class Informe extends Documento {
        private int paginas;

        /**
         * Constructor por defecto
         * @param titulo titulo del documento
         * @param paginas numero de paginas
         */
        public Informe(String titulo, int paginas) {
            super(titulo);
            if(paginas <= 0 ){
                throw new IllegalArgumentException();
            }
            this.paginas = paginas;
        }

        public void setPaginas(int paginas) {
            this.paginas = paginas;
        }

        public int getPaginas() {
            return paginas;
        }
        
        @Override
        public String descripcion() {
            return "Informe: "+ titulo +" ("+paginas+" páginas)";
        }
    

}
