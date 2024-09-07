package br.com.pieceofpixel.screenmatch.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
