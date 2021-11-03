<div id="divMensagem"></div>
<g:formRemote name="frmProduto" url="[controller:'local',action:'salvar']" update="divMensagem">
    <label for="inputNome">Nome</label>
    <input id="inputNome" type="text" name="nome" value="${local.nome}"><br>

    <label for="inputNomeShow">Nome Show</label>
    <input id="inputNomeShow" type="text" name="nomeShow" value="${local.nomeShow}"><br>

    <label for="inputCapacidade">Capacidade</label>
    <input id="inputCapacidade" type="number" min="1" name="capacidade" value="${local.capacidade}"><br>

    <input type="submit" name="btnSalvar" value="Salvar" />
    <input type="button" name="btnCancelar" value="Cancelar">
</g:formRemote>