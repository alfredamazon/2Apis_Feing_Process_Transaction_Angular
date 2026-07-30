
package com.plataformasespeciales.api_transacciones.repository;
import com.plataformasespeciales.api_transacciones.entity.Transaccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {


    /*
     * ======================================================
     * PAGINACIÓN Y ORDENAMIENTO
     * ======================================================
     * Ejemplo:
     * /transacciones?page=0&size=10&sort=importe,desc
     *
     * JpaRepository ya proporciona:
     * Page<T> findAll(Pageable pageable)
     *
     * No requiere implementación adicional.
     */
    Page<Transaccion> findAll(Pageable pageable);



    /*
     * ======================================================
     * BUSCAR POR REFERENCIA
     * ======================================================
     *
     * Útil para validar si una referencia ya existe.
     */
    Transaccion findByReferencia(Integer referencia);



    /*
     * ======================================================
     * ACTUALIZAR ESTATUS
     * ======================================================
     *
     * Requerimiento:
     * PATCH para cambiar:
     * Aprobada -> Cancelada
     *
     * Recibe:
     * id
     * referencia
     * estatus
     */
    @Modifying
    @Transactional
    @Query("""
            UPDATE Transaccion t
            SET t.estatus = :estatus
            WHERE t.id = :id
            AND t.referencia = :referencia
            """)
    int actualizarEstatus(
            @Param("id") Long id,
            @Param("referencia") Integer referencia,
            @Param("estatus") String estatus
    );



    /*
     * ======================================================
     * BUSCAR POR ESTATUS
     * ======================================================
     *
     * Ejemplo:
     * Obtener todas las aprobadas
     */
    Page<Transaccion> findByEstatus(
            String estatus,
            Pageable pageable
    );


}