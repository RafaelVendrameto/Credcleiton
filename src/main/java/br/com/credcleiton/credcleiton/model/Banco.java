package br.com.credcleiton.credcleiton.model;

import javax.persistence.*;

@Entity
@Table(name = "banco")
    public class Banco{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private  long id;
        @Column
        private String nome;
        @Column
        private String tipoEmprestimo;
        @Column
        private double taxa;
        @Column
        private String imagem;
        @Column
        private String linkBanco;

        private double juros = 0;
        private double totalEmprestimo = 0;
        private double totalParcela = 0;

    public String getLinkBanco() {
        return linkBanco;
    }

    public void setLinkBanco(String linkBanco) {
        this.linkBanco = linkBanco;
    }

    public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTipoEmprestimo() {
            return tipoEmprestimo;
        }

        public void setTipoEmprestimo(String tipoEmprestimo) {
            this.tipoEmprestimo = tipoEmprestimo;
        }

        public double getTaxa() {
            return taxa;
        }

        public void setTaxa(double taxa) {
            this.taxa = taxa;
        }

        public String getImagem() {
        return imagem;
    }

        public void setImagem(String imagem) {
        this.imagem = imagem;
    }

        public double getJuros() {
            return juros;
        }

        public void setJuros(double juros) {
            this.juros = juros;
        }

        public double getTotalEmprestimo() {
            return totalEmprestimo;
        }

        public void setTotalEmprestimo(double totalEmprestimo) {
            this.totalEmprestimo = totalEmprestimo;
        }

        public double getTotalParcela() {
            return totalParcela;
        }

        public void setTotalParcela(double totalParcela) {
        this.totalParcela = totalParcela;
    }
}


