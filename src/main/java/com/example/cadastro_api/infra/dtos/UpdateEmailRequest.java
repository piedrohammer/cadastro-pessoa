package com.example.cadastro_api.infra.dtos;

//Fiz para tratamento de exibição de mensagem no postman
//Sem ela estava exibindo assim -> "email": "{\r\n  \"novoEmail\": \"novoemail@email.com\"\r\n}"
//O correto tem que ser exibido assim -> "email": "novoemail@email.com"
public class UpdateEmailRequest {

    private String novoEmail;

    public String getNovoEmail() {
        return novoEmail;
    }
    public void setNovoEmail(String novoEmail) {
        this.novoEmail = novoEmail;
    }
}
