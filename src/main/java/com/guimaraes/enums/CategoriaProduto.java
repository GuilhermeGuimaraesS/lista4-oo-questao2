package com.guimaraes.enums;

public enum CategoriaProduto {

    ALIMENTO("alimento"),
    ELETRONICO("eletronico"),
    LIMPEZA("limpeza"),
    VESTUARIO("vestuario"),
    OUTROS("outros");

    private final String categoria;

    CategoriaProduto(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public static CategoriaProduto stringParaCategoria(String categoria){
        for (CategoriaProduto categoriaProduto : CategoriaProduto.values()){
            if (categoriaProduto.getCategoria().equalsIgnoreCase(categoria)){
                return categoriaProduto;
            }
        }

        throw new IllegalArgumentException("Categoria inválida: " + categoria);
    }
}