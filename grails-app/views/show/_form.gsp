<div id="divMensagem"></div>
<g:formRemote name="frmShow" url="[controller:'show',action:'salvar']" update="divMensagem"
              onSuccess="carregarLista()">

    <label for="dataInput">data do show:</label>
    <input type="date" id="dataInput" name="dataShow"
           min="${show?.dataDoShow.format("yyyy-MM-dd")}"
           <g:if test="${show?.id == null}">
           value="${show?.dataDoShow.format("yyyy-MM-dd")}">
           </g:if>
    <br>
    <select style="margin-top: 10px;" id="selectLocais" required name="locais">
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