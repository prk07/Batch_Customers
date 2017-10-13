CREATE TABLE "TB_CUSTOMER_ACCOUNT"
  (
     "id_customer" NUMBER NOT NULL,
     "cpf_cnpj"    VARCHAR2(18) NOT NULL,
     "nm_customer" VARCHAR2(30) NOT NULL,
     "is_active"   NUMBER(1, 0) NOT NULL,
     "vl_total"    FLOAT NOT NULL,
     CONSTRAINT "TB_CUSTOMER_ACCOUNT_PK" PRIMARY KEY ("id_customer")
  );
