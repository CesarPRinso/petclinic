<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Mascota">
    <h1 class="page-header"> Nueva Visita </h1>

    <form action="${pageContext.request.contextPath}/com/atencion/save" method="post">

        <input type="hidden" name="id" value="${atencion.id}"/> 

        <div class="form-group">
            <label class="control-label"> Veterinario </label>

            <select name="veterinario.id" class="form-control" id="veterinario">
                <c:forEach items="${veterinarios}" var="e" >
                    <option value="${e.id}"  ${atencion.veterinario.id == e.id ? 'selected': '' } > ${e.persona.nombres} </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label class="control-label"> Mascotas </label>

            <select name="mascota.id" class="form-control" id="mascota">
                <c:forEach items="${mascotas}" var="e" >
                    <option value="${e.id}"  ${atencion.mascota.id == e.id ? 'selected': '' } > ${e.nombre} </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label class="control-label"> Motivo </label>
            <input type="text" class="form-control" name="motivo" value="${atencion.motivo}" required="">
        </div>    
        
        <div class="form-group">
            <label class="control-label"> Fecha de proxima Visita </label>
            <input type="date" class="form-control" name="proximaVisita" value="${atencion.proximaVisita}" required="">
        </div>

        <div class="form-group">
            <label class="control-label"> Diagnostico </label>
            <input type="text" class="form-control" name="diagnostico" value="${atencion.diagnostico}" required="">
        </div>

        <div class="form-group">
            <label class="control-label"> Tratamiento </label>
            <input type="text" class="form-control" name="tratamiento" value="${atencion.tratamiento}" required="">
        </div>

        <div class="form-group">
            <label class="control-label"> Dieta </label>
            <input type="text" class="form-control" name="dieta" value="${atencion.dieta}" required="">
        </div>


        <div class="form-group text-center">
            <button type="submit" class="btn btn-primary">Guardar</button>
            <a href="${pageContext.request.contextPath}/com/atencion" class="btn btn-link">Cancelar</a>
        </div>


    </form>



</t:wrapper>



