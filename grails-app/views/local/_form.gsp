<div id="divMensagem"></div>
<g:formRemote name="frmLocal" url="[controller:'local',action:'salvar']" update="divMensagem"
onSuccess="carregarLista()">
    <label for="inputNome">Nome</label>
    <input id="inputNome" required type="text" name="nome" value="${local.nome}"><br>

    <label for="inputCapacidade">Capacidade</label>
    <input id="inputCapacidade" required type="number" min="1" name="capacidade" value="${local.capacidade}"><br>

    <input type="hidden" name="id" value="${local.id}"/>
    
    <input type="submit" name="btnSalvar" value="Salvar" />
    <input type="button" name="btnCancelar" value="Cancelar">
</g:formRemote>