CREATE FUNCTION categoria_crear(
    p_nombre_categoria varchar(100),
    p_descripcion_categoria varchar(250)
)
RETURNS BIGINT
LANGUAGE plpgsql
AS $$
DECLARE
    v_categoria_id BIGINT;
BEGIN
    INSERT INTO categoria(
    nombre_categoria,
    descripcion_categoria
    )VALUES (
p_nombre_categoria,
            p_descripcion_categoria
                )RETURNING categoria_id into v_categoria_id;
    RETURN v_categoria_id;
END;
$$;



