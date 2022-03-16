CREATE OR REPLACE FUNCTION object_class_updated() RETURNS TRIGGER
    LANGUAGE plpgsql
AS
$BODY$
BEGIN
    NEW.last_update_date := current_date;
    RETURN NEW;
END;
$BODY$;

CREATE OR REPLACE FUNCTION object_class_created() RETURNS TRIGGER
    LANGUAGE plpgsql
AS
$BODY$
BEGIN
    NEW.creation_date := current_date;
    RETURN NEW;
END;
$BODY$;

CREATE OR REPLACE FUNCTION object_class_created_by() RETURNS TRIGGER
    LANGUAGE plpgsql
AS
$BODY$
BEGIN
    NEW.created_by:= current_user;
    RETURN NEW;
END;
$BODY$;

CREATE OR REPLACE FUNCTION object_class_last_updated_by() RETURNS TRIGGER
    LANGUAGE plpgsql
AS
$BODY$
BEGIN
    NEW.last_updated_by:= current_user;
    RETURN NEW;
END;
$BODY$;