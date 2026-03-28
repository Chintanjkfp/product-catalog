CREATE TABLE products(
                         id BIGSERIAL PRIMARY KEY ,
                         name VARCHAR(200) NOT NULL ,
                         description TEXT,

                         price NUMERIC(12,2) NOT NULL CHECK ( price>=0 ),
                         stock INTEGER NOT NULL DEFAULT 0 CHECK ( stock>=0 ),

                         created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);