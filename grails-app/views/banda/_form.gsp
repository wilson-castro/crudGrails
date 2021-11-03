<div id="divMensagem"></div>
<g:formRemote name="frmBanda" url="[controller:'banda',action:'salvar']" update="divMensagem"
              onSuccess="carregarLista()">
    <label for="inputNome">Nome</label>
    <input id="inputNome" type="text" name="nome" value="${banda.nome}"><br>

    <label for="inputNomeShow">Nome Show</label>
    <input id="inputNomeShow" type="text" name="nomeShow" value="${banda.genero}"><br>

    <label for="inputCapacidade">Capacidade</label>
    <input id="inputCapacidade" type="number" min="1" name="capacidade" value="${banda.shows}"><br>

    <input type="hidden" name="id" value="${banda.id}"/>

    <input type="submit" name="btnSalvar" value="Salvar" />
    <input type="button" name="btnCancelar" value="Cancelar">
</g:formRemote>