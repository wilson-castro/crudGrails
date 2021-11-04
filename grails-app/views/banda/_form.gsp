<div id="divMensagem"></div>
<g:formRemote name="frmBanda" url="[controller:'banda',action:'salvar']" update="divMensagem"
              onSuccess="carregarLista()">
    <label for="inputNome">Nome</label>
    <input id="inputNome" required type="text" name="nome" value="${banda.nome}"><br>

    <div style="margin: 10px; margin-left: 50px">
        <select id="selectGeneros" required name="genero">
            <option value="-selecione-">Selecione o genero</option>
            <option value="ROCK" >ROCK</option>
            <option value="FORRO">FORRÓ</option>
            <option value=AXE>AXÉ</option>
        </select>
    </div>

    <input type="hidden" name="id" value="${banda.id}"/>

    <input type="submit" name="btnSalvar" value="Salvar" />
    <input type="button" name="btnCancelar" value="Cancelar">
</g:formRemote>