PGDMP     (                     x         
   tigerscave    12.2    12.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16393 
   tigerscave    DATABASE     �   CREATE DATABASE tigerscave WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Japanese_Japan.932' LC_CTYPE = 'Japanese_Japan.932';
    DROP DATABASE tigerscave;
                postgres    false            �            1259    16394    items    TABLE     u   CREATE TABLE public.items (
    item_id integer NOT NULL,
    item_name text NOT NULL,
    price integer NOT NULL
);
    DROP TABLE public.items;
       public         heap    postgres    false                       0    16394    items 
   TABLE DATA           :   COPY public.items (item_id, item_name, price) FROM stdin;
    public          postgres    false    202   L       �
           2606    16401    items items_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_pkey PRIMARY KEY (item_id);
 :   ALTER TABLE ONLY public.items DROP CONSTRAINT items_pkey;
       public            postgres    false    202                �   x��=
1F���dB�{�-V�,-��,V�-�c�M���>'B��t!�C����F*V�߮'焵&�+l�}�v��a}������n���x��&���tڰ�Rn�Б΅c����z�3��C�     