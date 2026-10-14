CREATE FUNCTION categoria_actualizar(
    p_categoria_id BIGINT,
    p_nombre_categoria varchar(100),
    p_descrcipcion_categoria varchar(250)
)
RETURNS SETOF categoria
LANGUAGE plpgsql
AS $$
   BEGIN
       RETURN QUERY
       UPDATE categoria AS c
       SET
           nombre_categoria = p_nombre_categoria,
           descripcion_categoria = p_descrcipcion_categoria
       WHERE c.categoria_id = p_categoria_id
       RETURNING c.*;
   END;
$$;