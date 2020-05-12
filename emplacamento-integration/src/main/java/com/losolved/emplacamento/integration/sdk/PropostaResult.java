package com.losolved.emplacamento.integration.sdk;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"numero_proposta",
"numero_pedido",
"valor_proposta",
"valor_nf",
"valor_financiado",
"nome_cliente",
"codigo_veiculo",
"modelo_veiculo",
"placa",
"uf_placa",
"chassi",
"numero_motor",
"renavam",
"combustivel",
"cor_externa",
"classificacao",
"estqoue",
"vendedor_proposta"
})
public class PropostaResult {

@JsonProperty("numero_proposta")
private String numeroProposta;
@JsonProperty("numero_pedido")
private String numeroPedido;
@JsonProperty("valor_proposta")
private String valorProposta;
@JsonProperty("valor_nf")
private String valorNf;
@JsonProperty("valor_financiado")
private Object valorFinanciado;
@JsonProperty("nome_cliente")
private String nomeCliente;
@JsonProperty("codigo_veiculo")
private String codigoVeiculo;
@JsonProperty("modelo_veiculo")
private String modeloVeiculo;
@JsonProperty("placa")
private Object placa;
@JsonProperty("uf_placa")
private Object ufPlaca;
@JsonProperty("chassi")
private String chassi;
@JsonProperty("numero_motor")
private String numeroMotor;
@JsonProperty("renavam")
private String renavam;
@JsonProperty("combustivel")
private String combustivel;
@JsonProperty("cor_externa")
private String corExterna;
@JsonProperty("classificacao")
private String classificacao;
@JsonProperty("estqoue")
private String estqoue;
@JsonProperty("vendedor_proposta")
private String vendedorProposta;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("numero_proposta")
public String getNumeroProposta() {
return numeroProposta;
}

@JsonProperty("numero_proposta")
public void setNumeroProposta(String numeroProposta) {
this.numeroProposta = numeroProposta;
}

@JsonProperty("numero_pedido")
public String getNumeroPedido() {
return numeroPedido;
}

@JsonProperty("numero_pedido")
public void setNumeroPedido(String numeroPedido) {
this.numeroPedido = numeroPedido;
}

@JsonProperty("valor_proposta")
public String getValorProposta() {
return valorProposta;
}

@JsonProperty("valor_proposta")
public void setValorProposta(String valorProposta) {
this.valorProposta = valorProposta;
}

@JsonProperty("valor_nf")
public String getValorNf() {
return valorNf;
}

@JsonProperty("valor_nf")
public void setValorNf(String valorNf) {
this.valorNf = valorNf;
}

@JsonProperty("valor_financiado")
public Object getValorFinanciado() {
return valorFinanciado;
}

@JsonProperty("valor_financiado")
public void setValorFinanciado(Object valorFinanciado) {
this.valorFinanciado = valorFinanciado;
}

@JsonProperty("nome_cliente")
public String getNomeCliente() {
return nomeCliente;
}

@JsonProperty("nome_cliente")
public void setNomeCliente(String nomeCliente) {
this.nomeCliente = nomeCliente;
}

@JsonProperty("codigo_veiculo")
public String getCodigoVeiculo() {
return codigoVeiculo;
}

@JsonProperty("codigo_veiculo")
public void setCodigoVeiculo(String codigoVeiculo) {
this.codigoVeiculo = codigoVeiculo;
}

@JsonProperty("modelo_veiculo")
public String getModeloVeiculo() {
return modeloVeiculo;
}

@JsonProperty("modelo_veiculo")
public void setModeloVeiculo(String modeloVeiculo) {
this.modeloVeiculo = modeloVeiculo;
}

@JsonProperty("placa")
public Object getPlaca() {
return placa;
}

@JsonProperty("placa")
public void setPlaca(Object placa) {
this.placa = placa;
}

@JsonProperty("uf_placa")
public Object getUfPlaca() {
return ufPlaca;
}

@JsonProperty("uf_placa")
public void setUfPlaca(Object ufPlaca) {
this.ufPlaca = ufPlaca;
}

@JsonProperty("chassi")
public String getChassi() {
return chassi;
}

@JsonProperty("chassi")
public void setChassi(String chassi) {
this.chassi = chassi;
}

@JsonProperty("numero_motor")
public String getNumeroMotor() {
return numeroMotor;
}

@JsonProperty("numero_motor")
public void setNumeroMotor(String numeroMotor) {
this.numeroMotor = numeroMotor;
}

@JsonProperty("renavam")
public String getRenavam() {
return renavam;
}

@JsonProperty("renavam")
public void setRenavam(String renavam) {
this.renavam = renavam;
}

@JsonProperty("combustivel")
public String getCombustivel() {
return combustivel;
}

@JsonProperty("combustivel")
public void setCombustivel(String combustivel) {
this.combustivel = combustivel;
}

@JsonProperty("cor_externa")
public String getCorExterna() {
return corExterna;
}

@JsonProperty("cor_externa")
public void setCorExterna(String corExterna) {
this.corExterna = corExterna;
}

@JsonProperty("classificacao")
public String getClassificacao() {
return classificacao;
}

@JsonProperty("classificacao")
public void setClassificacao(String classificacao) {
this.classificacao = classificacao;
}

@JsonProperty("estqoue")
public String getEstqoue() {
return estqoue;
}

@JsonProperty("estqoue")
public void setEstqoue(String estqoue) {
this.estqoue = estqoue;
}

@JsonProperty("vendedor_proposta")
public String getVendedorProposta() {
return vendedorProposta;
}

@JsonProperty("vendedor_proposta")
public void setVendedorProposta(String vendedorProposta) {
this.vendedorProposta = vendedorProposta;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
	
	
	
	


