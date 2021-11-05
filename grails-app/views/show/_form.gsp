<div id="divMensagem"></div>
<g:formRemote name="frmShow" url="[controller:'show',action:'salvar']" update="divMensagem"
              onSuccess="carregarLista()">

    <label  for="dataInput">data do show:</label>
    <input required type="date" id="dataInput" name="dataShow"
        <g:if test="${show?.id == null}">
            min="${show?.dataDoShow.format("yyyy-MM-dd")}"
            value="${show?.dataDoShow.format("yyyy-MM-dd")}">
        </g:if>
        <g:else>
            value="${show?.dataDoShow.format("yyyy-MM-dd")}"
            min="${new Date().format("yyyy-MM-dd")}">
        </g:else>
    <br>
    <select style="margin-top: 10px;" id="selectLocais" required name="localID">
        <option value="-selecione-">Selecione o Local</option>
        <g:each var="local" in="${locais}">
            <option value="<%=local.id %>" >
                <%=local.id %> -
                <%=local.nome %> -
                <%=local.capacidade %>
            </option>
        </g:each>
    </select>

   <g:if test="${bandas.size()>0}">
       <h5>Bandas</h5>
   </g:if>
    <div class="group-checkbox" style="margin-bottom: 10px;">
        <g:each var="banda" in="${bandas}">
            <input type="checkbox"
               id="<%=banda.id %>"
               name="List_BandaIDs" value=<%= banda.id %>
            >
            <label for="<%= banda.id %>">
                <strong>ID</strong>: <%= banda.id %> -
                <strong>Nome</strong>: <%= banda.nome %> -
                <strong>Genero</strong>: <%= banda.genero %>
            </label><br>
        </g:each>
    </div>

    <input type="hidden" name="id" value="${show?.id}"/>

    <input type="submit" name="btnSalvar" value="Salvar" />
    <input type="button" name="btnCancelar" value="Cancelar">
</g:formRemote>